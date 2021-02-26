<template>
    <el-table
      :data="tableData"
      style="width: 100%"
      border
      >
      <el-table-column
        prop="time"
        label="时间"
        width="180">
      </el-table-column>
      <el-table-column
        prop="nickname"
        label="昵称"
        width="180">
      </el-table-column>
      <el-table-column
        prop="advice"
        label="意见">
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
  name: 'feedback',
  data(){
    return{
      tableData:[]
    }
  },
    methods: {
      getData(){
              var api=this.SERVICE_PATH + '/api/backstage/advice/getadvicelist';
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
                    data.nickname = res.data.data[i].nickname;
                    data.advice = res.data.data[i].content;
                    data.time = res.data.data[i].time.year+'-'
                                            +res.data.data[i].time.monthValue+'-'
                                            +res.data.data[i].time.dayOfMonth+' '
                                            +res.data.data[i].time.hour+':'
                                            +res.data.data[i].time.minute;
                    data.id = res.data.data[i].adviceid;
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
        var api = this.SERVICE_PATH+'/api/backstage/advice/deleteadvice';
        axios
        .post(api+'?adviceid='+row.id)
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

<style>
</style>