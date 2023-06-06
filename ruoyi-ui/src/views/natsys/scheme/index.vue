<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="采样方式" prop="samplingMethod">
        <el-select v-model="queryParams.samplingMethod" placeholder="请选择采样方式" clearable>
          <el-option
            v-for="dict in dict.type.sys_sampling_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="检测方式" prop="testingMethod">
        <el-select v-model="queryParams.testingMethod" placeholder="请选择检测方式" clearable>
          <el-option
            v-for="dict in dict.type.sys_testing_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['natsys:scheme:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['natsys:scheme:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['natsys:scheme:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['natsys:scheme:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="schemeList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="检测方案id" align="center" prop="schemeId" />
      <el-table-column label="采样方式" align="center" prop="samplingMethod">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_sampling_type" :value="scope.row.samplingMethod"/>
        </template>
      </el-table-column>
      <el-table-column label="检测方式" align="center" prop="testingMethod">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_testing_type" :value="scope.row.testingMethod"/>
        </template>
      </el-table-column>
      <el-table-column label="检测流程" align="center" prop="inspectionProcess" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['natsys:scheme:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['natsys:scheme:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改检测方案对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="采样方式" prop="samplingMethod">
          <el-select v-model="form.samplingMethod" placeholder="请选择采样方式">
            <el-option
              v-for="dict in dict.type.sys_sampling_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="检测方式" prop="testingMethod">
          <el-select v-model="form.testingMethod" placeholder="请选择检测方式">
            <el-option
              v-for="dict in dict.type.sys_testing_type"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="检测流程" prop="inspectionProcess">
          <el-input v-model="form.inspectionProcess" placeholder="请输入检测流程" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listScheme, getScheme, delScheme, addScheme, updateScheme } from "@/api/natsys/scheme";

export default {
  name: "Scheme",
  dicts: ['sys_sampling_type', 'sys_testing_type'],
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 检测方案表格数据
      schemeList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        samplingMethod: null,
        testingMethod: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        samplingMethod: [
          { required: true, message: "采样方式不能为空", trigger: "change" }
        ],
        testingMethod: [
          { required: true, message: "检测方式不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询检测方案列表 */
    getList() {
      this.loading = true;
      listScheme(this.queryParams).then(response => {
        this.schemeList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        schemeId: null,
        samplingMethod: null,
        testingMethod: null,
        inspectionProcess: null,
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.schemeId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加检测方案";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const schemeId = row.schemeId || this.ids
      getScheme(schemeId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改检测方案";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.schemeId != null) {
            updateScheme(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addScheme(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const schemeIds = row.schemeId || this.ids;
      this.$modal.confirm('是否确认删除检测方案编号为"' + schemeIds + '"的数据项？').then(function() {
        return delScheme(schemeIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('natsys/scheme/export', {
        ...this.queryParams
      }, `scheme_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
