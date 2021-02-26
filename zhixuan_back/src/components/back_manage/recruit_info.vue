<template>
  <el-form ref="form" :model="form" :rules="rules" label-width="100px">
    <el-form-item class="input" style="margin: 20px 0;" label="搜索框:" prop="search" >
      <el-input v-model="form.search" placeholder="请输入搜索框关键词"></el-input>
    </el-form-item>
    <el-form-item  label="筛选框:" prop="select">
      <el-col :span="4">
        <el-input v-model="form.time" placeholder="请输入时间"></el-input>
      </el-col>
      <el-col :span="4">
        <el-input v-model="form.academic" placeholder="请输入学历要求"></el-input>
      </el-col>
      <el-col :span="4">
        <el-input v-model="form.major" placeholder="请输入专业要求"></el-input>
      </el-col>
      <el-col :span="4">
        <el-input v-model="form.officehour" placeholder="请输入上班时间"></el-input>
      </el-col>
      <el-col :span="4">
        <el-input v-model="form.salary" placeholder="请输入薪资"></el-input>
      </el-col>
    </el-form-item>
    <hr/>
    <el-form-item class="input" style="margin: 20px 0;" label="公司名称:" prop="name">
      <el-input v-model="form.company" placeholder="请输入公司名称"></el-input>
    </el-form-item>
    <el-form-item class="input2" label="公司介绍:" prop="introduction">
      <el-input type="textarea" v-model="form.introduction" placeholder="请输入公司介绍"></el-input>
    </el-form-item>
    <el-form-item class="input" label="招聘岗位:" prop="position">
      <el-input v-model="form.position" placeholder="请输入招聘岗位"></el-input>
    </el-form-item>
    <hr/>
    <el-form-item class="input2" style="margin: 20px 0;" label="相关信息:" prop="relativeinfo">
      <el-input type="textarea" v-model="form.relativeinfo" placeholder="请输入相关信息"></el-input>
    </el-form-item>
    <hr/>
    <el-form-item class="input2" style="margin: 20px 0;" label="具体信息:" prop="detailedinfo">
      <el-input type="textarea" v-model="form.detailedinfo" placeholder="请输入具体信息"></el-input>
    </el-form-item>
    <hr/>
    <el-form-item class="input2" style="margin: 20px 0;" label="应聘方式:" prop="application">
      <el-input type="textarea" v-model="form.application" placeholder="请输入应聘方式"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit('form')">立即上传</el-button>
    </el-form-item>
  </el-form>
</template>


<script>
import axios from "axios";
export default {
  name: 'recruit',
  data(){
    return{
      form:{
        search:'',
        time:'',
        academic:'',
        major:'',
        officehour:'',
        salary:'',
        company:'',
        introduction:'',
        relativeinfo:'',
        detailedinfo:'',
        application:'',
        position:'',
      },
      rules:{
        search:[{required:true,message:'请输入搜索框关键词',trigger:'blur'}],
        select:[{required:true,message:'请输入筛选框关键词',trigger:'blur'}],
        name:[{required:true,message:'请输入公司名称',trigger:'blur'}],
        introduction:[{required:true,message:'请输入公司介绍',trigger:'blur'}],
        position:[{required:true,message:'请输入招聘岗位',trigger:'blur'}],
        relativeinfo:[{required:true,message:'请输入相关信息',trigger:'blur'}],
        detailedinfo:[{required:true,message:'请输入具体信息',trigger:'blur'}],
        application:[{required:true,message:'请输入应聘方式',trigger:'blur'}],
      },
    };
  },
  methods:{
     onSubmit(formName) {
       this.$refs[formName].validate((valid) => {
          if (valid) {
            var api=this.SERVICE_PATH + '/api/backstage/advice/addposinfo?search='
                +this.search+'&time='+this.time+'&academic='+this.academic
                +'&major='+this.major+'&officehour='+this.officehour
                +'&salary='+this.salary+'&company='+this.company
                +'&introduction='+this.introduction+'&relativeinfo='+this.relativeinfo
                +'&detailedinfo='+this.detailedinfo+'&application='+this.application
                +'&position='+this.position;
            var that = this;
            axios
            .get(api)
            .then(function(res) {
              that.$message.success('上传成功！');
              console.log(res.data.data);
            })
            .catch(function (error) {
              that.$message.error('上传失败！');
              console.log(error);
            });
          } else {
            this.$message.error('请输入完整信息！');
            return false;
          }
        });
       
      }
  },
}
</script>

<style scoped>
.input{
  width: 30%;
}
.input2{
  width:60%;
}
</style>


