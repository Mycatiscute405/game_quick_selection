<template>
  <div id="app">
    <game-main />
  </div>
</template>

<script>
import GameMain from '././views/game-module/GameMain.vue';

export default {
  components: {
    GameMain,
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
