<template>
    <el-table
      :data="tableData"
      style="width: 100%"
      border
      >
      <el-table-column
        prop="search"
        label="搜索框关键词">
      </el-table-column>
      <el-table-column
        prop="time"
        label="时间">
      </el-table-column>
      <el-table-column
        prop="academic"
        label="学历要求">
      </el-table-column>
      <el-table-column
        prop="major"
        label="专业要求">
      </el-table-column>
      <el-table-column
        prop="officehour"
        label="上班时间">
      </el-table-column>
      <el-table-column
        prop="salary"
        label="薪资">
      </el-table-column>
      <el-table-column
        prop="company"
        label="公司名称">
      </el-table-column>
      <el-table-column
        prop="introduction"
        label="公司介绍">
      </el-table-column>
      <el-table-column
        prop="relativeinfo"
        label="相关信息">
      </el-table-column>
      <el-table-column
        prop="detailedinfo"
        label="具体信息">
      </el-table-column>
      <el-table-column
        prop="application"
        label="应聘方式">
      </el-table-column>
      <el-table-column label="操作" width="180">
      <template slot-scope="scope">
        <el-button
          size="mini"
          type="danger"
          @click="handleDelete(scope.$index, scope.row, tableData)">删除</el-button>
      </template>
    </el-table-column>
    </el-table>
</template>

<script>
import axios from "axios";
export default {
    data(){
    return{
      tableData:[]
    }
  },
    methods: {
      getData(){
              var api=this.SERVICE_PATH + '/api/homepage/positioninfo/getposinfolist';
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
                    var data={};
                    data.academic = res.data.data[i].academic;
                    data.application = res.data.data[i].application;
                    data.company = res.data.data[i].company;
                    data.detailedinfo = res.data.data[i].detailedinfo;
                    data.introduction = res.data.data[i].introduction;
                    data.company = res.data.data[i].company;
                    data.major = res.data.data[i].major;
                    data.officehour = res.data.data[i].officehour;
                    data.relativeinfo = res.data.data[i].relativeinfo;
                    data.salary = res.data.data[i].salary;
                    data.search = res.data.data[i].search;
                    data.time = res.data.data[i].time;
                    data.id = res.data.data[i].listid;
                    console.log(data);
                    this.tableData.push(data);
                  }
                  console.log(this.tableData);
                }
              else
                console.log("error!");
              })
              .catch(function (error) {
              console.log(error);
              });
      },
      handleDelete(index, row, rows) {
        console.log(row.id);
        rows.splice(index, 1);
        var api = this.SERVICE_PATH+'/api/backstage/advice/deletepositioninfo';
        axios
        .post(api+'?listid='+row.id)
        .then(res=> {
        console.log(res.data.data);
        })
        .catch(function (error) {
        console.log(error);
        });
      }
    },
  mounted(){ 
        this.getData();
        }    
}
</script>
<style scoped>

</style>