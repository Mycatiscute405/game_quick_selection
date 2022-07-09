<template>
  <div>
    <div>
      <game-view />
    </div>
    <div>
      <record-view />
    </div>
  </div>
</template>

<script>
import GameView from './sub-view/GameView.vue';
import RecordView from './sub-view/RecordView.vue';

export default {
  components: {
    GameView,
    RecordView,
  },
};
</script>

<style lang="scss"></style>
