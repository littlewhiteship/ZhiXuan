<template>
  <div class="body">
    <div class="form-demo">
      <el-form :inline="true" :model="form"  ref="form" label-width="100px">
        <el-form-item label="图片链接：" placeholder="请输入有效的图片url链接">
          <el-input v-model="link" @keyup.enter.native="onSubmit"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">立即上传</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div v-for="item in imgs" :key="item.id" class="img-block">
      <el-image :src="item.adverurl"/>
      <el-button size="mini" type="danger" @click="deleteImg(item.adverid,item.index)">删除图片</el-button>
    </div>
  </div> 
</template>


<script>
import axios from "axios";
export default {
  data() {
      return {
        link:'',
        imgs:[],
      };
    },
    methods: {
      onSubmit(){
        var api=this.SERVICE_PATH + '/api/backstage/advice/addadv?url='+this.link;
        var that = this;
        axios
        .get(api)
        .then(function(res) {
          that.$message.success('上传成功！');
          console.log(res.data.data);
          that.link='';
        })
        .catch(function (error) {
          that.$message.error('上传失败！');
          console.log(error);
        });
      },
      getData(){
        var api=this.SERVICE_PATH + '/api/homepage/positioninfo/getadver';
              axios
              .post(api)
              .then(res=> {
              console.log(res.data.data);
              if(res.data.errcode==0)
              {
                var num = res.data.data.length;
                console.log(num);
                for(var i=0;i<num;i++)
                {
                  var imgurl={};
                  imgurl.adverid=res.data.data[i].adverid;
                  imgurl.adverurl=res.data.data[i].adverurl;
                  imgurl.index=i;
                  console.log(imgurl)
                  this.imgs.push(imgurl);
                }
                console.log(this.imgs);
              }
              else
                console.log("error!");
              })
              .catch(function (error) {
              console.log(error);
              });
      },
      deleteImg(adverid,index){
        console.log(adverid)
        console.log(index)
        this.imgs.splice(index+1,1)
        var api = this.SERVICE_PATH+'/api/backstage/advice/deleteadv';
        axios
        .get(api+'?id='+adverid)
        .then(res=> {
        console.log(res.data.data);
        this.imgs=[]
        if(res.data.errcode==0)
        {
          var num = res.data.data.length;
          console.log(num);
          for(var i=0;i<num;i++)
          {
            var imgurl={};
            imgurl.adverid=res.data.data[i].adverid;
            imgurl.adverurl=res.data.data[i].adverurl;
            imgurl.index=i;
            console.log(imgurl)
            this.imgs.push(imgurl);
          }
          console.log(this.imgs);
          this.$forceUpdate();
        }
        else
          console.log("error!");
        })
        .catch(function (error) {
        console.log(error);
        });
      },
    },
    mounted(){ 
      this.getData();
    },  
}
</script>

<style scoped>
.body{
  position: absolute;
  top: 15%;
}
.img-block{
  display:inline-block;
  width: 160px;
  height: 90px;
  margin: 15px;
}
</style>
 