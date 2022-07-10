<template>
  <div>
    <div id="end-blind" v-if="isEndGame">
      <div id="end-modal">TEST</div>
    </div>
    <div>
      <game-view @setBlindGame="setBlindGame" />
    </div>
    <div>
      <!-- <record-view /> -->
    </div>
  </div>
</template>

<script>
import GameView from './sub-view/GameView.vue';
// import RecordView from './sub-view/RecordView.vue';

export default {
  components: {
    GameView,
    // RecordView,
  },
  data() {
    return {
      isEndGame: false,
    };
  },
  methods: {
    setBlindGame() {
      this.isEndGame = true;
    },
  },
};
</script>

<style lang="scss">
body {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

#end-blind {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.3);
  z-index: 11;
}
#end-modal {
  position: relative;
  background: white;
  height: 100px;
  width: 100px;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
  padding: 10px;
  border: 1px solid rgba(168, 168, 168, 0.5);
  border-radius: 15px;
  box-shadow: 0 0 5px 10px rgba(83, 83, 83, 0.2);
}
</style>
