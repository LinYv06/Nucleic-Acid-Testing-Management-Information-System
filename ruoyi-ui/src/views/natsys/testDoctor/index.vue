<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="检测记录" prop="testId">
        <el-input
          v-model="queryParams.testId"
          placeholder="请输入检测记录ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检测结果" prop="testResult">
        <el-select v-model="queryParams.testResult" placeholder="请选择检测结果" clearable>
          <el-option
            v-for="dict in dict.type.sys_testing_result"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="检测人员" prop="doctorName">
        <el-input
          v-model="queryParams.doctorName"
          placeholder="请输入检测人员姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检测时间">
        <el-date-picker
          v-model="daterangeAuditTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item label="人脸识别" prop="ifRecognition">
        <el-select v-model="queryParams.ifRecognition" placeholder="请选择是否通过" clearable>
          <el-option
            v-for="dict in dict.type.sys_if_recognition"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <br />
      <el-form-item label="受检人" prop="patientName">
        <el-input
          v-model="queryParams.patientName"
          placeholder="请输入受检人姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="检测方案" prop="schemeId">
        <el-select v-model="queryParams.schemeId" placeholder="请选择检测方案" clearable>
          <el-option
            v-for="dict in dict.type.sys_sampling_type"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="采样地点" prop="testLocation">
        <el-select v-model="queryParams.testLocation" placeholder="请选择采样地点（可搜索）" clearable filterable>
          <el-option
            v-for="dict in dict.type.sys_sampling_location"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="采样时间">
        <el-date-picker
          v-model="daterangeTestTime"
          style="width: 240px"
          value-format="yyyy-MM-dd"
          type="daterange"
          range-separator="-"
          start-placeholder="开始日期"
          end-placeholder="结束日期"
        ></el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['natsys:testDoctor:edit']"
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
          v-hasPermi="['natsys:testDoctor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['natsys:testDoctor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="testDoctorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="检测记录" align="center" prop="testId" />
      <el-table-column label="受检人" align="center" prop="patientName" />
      <el-table-column label="检测方案" align="center" prop="schemeId">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_sampling_type" :value="scope.row.schemeId"/>
        </template>
      </el-table-column>
      <el-table-column label="采样时间" align="center" prop="testTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.testTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="采样地点" align="center" prop="testLocation">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_sampling_location" :value="scope.row.testLocation"/>
        </template>
      </el-table-column>
      <el-table-column label="是否已人脸识别" align="center" prop="ifRecognition">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_if_recognition" :value="scope.row.ifRecognition"/>
        </template>
      </el-table-column>
      <el-table-column label="检测结果" align="center" prop="testResult">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_testing_result" :value="scope.row.testResult"/>
        </template>
      </el-table-column>
      <el-table-column label="检测人员" align="center" prop="doctorName" />
      <el-table-column label="检测时间" align="center" prop="auditTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.auditTime, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['natsys:testDoctor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['natsys:testDoctor:remove']"
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

    <!-- 添加或修改检测记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="人脸识别" prop="ifRecognition">
          <el-select v-model="form.ifRecognition" placeholder="请选择是否通过">
            <el-option
              v-for="dict in dict.type.sys_if_recognition"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="检测结果" prop="testResult">
          <el-select v-model="form.testResult" placeholder="请选择检测结果">
            <el-option
              v-for="dict in dict.type.sys_testing_result"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
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
import { listTestDoctor, getTestDoctor, delTestDoctor, addTestDoctor, updateTestDoctor } from "@/api/natsys/testDoctor";

export default {
  name: "TestDoctor",
  dicts: ['sys_sampling_location', 'sys_sampling_type', 'sys_testing_result', 'sys_if_recognition'],
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
      // 检测记录表格数据
      testDoctorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 检测时间时间范围
      daterangeTestTime: [],
      // 检测时间时间范围
      daterangeAuditTime: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        testId: null,
        patientId: null,
        patientName:null,
        schemeId: null,
        testTime: null,
        testLocation: null,
        testResult: null,
        auditorId: null,
        auditTime: null,
        ifRecognition: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        patientId: [
          { required: true, message: "受检人不能为空", trigger: "blur" }
        ],
        schemeId: [
          { required: true, message: "检测方案不能为空", trigger: "change" }
        ],
        testTime: [
          { required: true, message: "采样时间不能为空", trigger: "blur" }
        ],
        testLocation: [
          { required: true, message: "采样地点不能为空", trigger: "change" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询检测记录列表 */
    getList() {
      this.loading = true;
      this.queryParams.params = {};
      if (null != this.daterangeTestTime && '' != this.daterangeTestTime) {
        this.queryParams.params["beginTestTime"] = this.daterangeTestTime[0];
        this.queryParams.params["endTestTime"] = this.daterangeTestTime[1];
      }
      if (null != this.daterangeAuditTime && '' != this.daterangeAuditTime) {
        this.queryParams.params["beginAuditTime"] = this.daterangeAuditTime[0];
        this.queryParams.params["endAuditTime"] = this.daterangeAuditTime[1];
      }
      listTestDoctor(this.queryParams).then(response => {
        this.testDoctorList = response.rows;
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
        testId: null,
        patientId: null,
        schemeId: null,
        testArea: null,
        testLocation: null,
        testTime: null,
        ifRecognition: null,
        testResult: null,
        auditorId: null,
        auditTime: null,
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
      this.daterangeTestTime = [];
      this.daterangeAuditTime = [];
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.testId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加检测记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const testId = row.testId || this.ids
      getTestDoctor(testId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改检测记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.testId != null) {
            updateTestDoctor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTestDoctor(this.form).then(response => {
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
      const testIds = row.testId || this.ids;
      this.$modal.confirm('是否确认删除检测记录编号为"' + testIds + '"的数据项？').then(function() {
        return delTestDoctor(testIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('natsys/testDoctor/export', {
        ...this.queryParams
      }, `testDoctor_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
