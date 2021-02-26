<template>
  <div>
    <vheader></vheader>
    <router-view></router-view>
  </div>
</template>


<script>
import vheader from "./header"

export default {
  name: 'layout',
  components: {
    vheader
  }
}
</script>

<style>
</style>
