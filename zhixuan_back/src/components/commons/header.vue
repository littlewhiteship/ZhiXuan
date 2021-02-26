<template>
  <el-menu
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b"
    router>
    <el-menu-item index="recruit">招聘信息上传</el-menu-item>
    <el-menu-item index="recruit_batch">招聘信息批量上传</el-menu-item>
    <el-menu-item index="delete">招聘信息删除</el-menu-item>
    <el-menu-item index="feedback">意见反馈中心</el-menu-item>
    <el-menu-item index="ad">广告图片管理</el-menu-item>
  </el-menu>
</template>


<script>
export default {
  name: 'header',
  data() {
    
    },
  components: {
    
  },
   methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }
}
</script>

<style scoped>

</style>
