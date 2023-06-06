<template>
  <div>
    <el-image
      style="width: 400px; height: 100%"
      :src="imageUrl"
      :fit="contain">
      <div slot="error" class="image-slot">
      </div>
    </el-image><br/>
    <div class="upload-wrap anticon" nv-file-drop="" uploader="uploader">
        <input class="file-ele" type="file" file-model="image" name="image" nv-file-select uploader="uploader" multiple @change="handleFileUpload"/>
        <div class="file-open"><em class="icon icon-upload"></em>&nbsp;上传照片</div>    
    </div>
    <!-- <input type="file" @change="handleFileUpload"> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      imageFile: null, // 存放上传的图片文件
      imageUrl: ''     // 存放图片的URL
    }
  },
  methods: {
    handleFileUpload(event) {
      // 获取上传的图片文件
      this.imageFile = event.target.files[0];
      
      // 将图片文件转化为URL
      this.imageUrl = URL.createObjectURL(this.imageFile);
    }
  }
}
</script>

<style scoped>
.upload-wrap{
    position: relative;
    display: inline-block;
    overflow: hidden;
    border:1px solid #2d78f4;
    border-radius: 3px;
}
.upload-wrap .file-ele{
    position: absolute;
    top:0;
    right:0;
    opacity: 0;
    height: 100%;
    width: 100%;
    cursor: pointer;
}
.upload-wrap .file-open{
    width:90px;
    height:30px;
    line-height:30px;
    text-align: center;
    color:#fff;
    background: #409eff;
}
</style>