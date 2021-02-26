<template>
    <el-upload
    class="upload-demo"
    drag
    action="http://47.111.66.69:8081/api/backstage/advice/autoaddposinfo"
    accept=".xls"
    :before-upload="handleBeforeUpload"
    >
    <i class="el-icon-upload"></i>
    <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
    <div class="el-upload__tip" slot="tip">只能上传excel文件，且不超过10M</div>
    </el-upload>
</template>

<script>
//import axios from "axios";
export default {
  data() {
      return {
          //uploadURL:this.SERVICE_PATH+'/api/backstage/advice/autoaddposinfo'
      };
    },
    methods: {
      // 上传文件之前的钩子
      handleBeforeUpload(file){
      console.log('before upload');
        console.log(file);
        let extension = file.name.substring(file.name.lastIndexOf('.')+1);
        let size = file.size / 1024 / 1024;
        if(extension !== 'xls') {
          this.$message.warning('只能上传后缀是.xls的文件');
        }
        if(size > 10) {
          this.$message.warning('文件大小不得超过10M');
        }
    },
    }
}
</script>

<style scoped>
.upload-demo{
  position:absolute;
  left: 30%;
  top: 20%;
  width: 50%;
} 
</style>