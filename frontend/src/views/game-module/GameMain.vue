<template>
  <div>
    <div v-if="isEndGame">
      <result-modal
        :score="score"
        :title="title"
        @onCloseModal="onCloseModal"
      />
    </div>
    <div>
      <game-view
        @setBlindGame="setBlindGame"
        @setScore="setScore"
        @setModalTitle="setModalTitle"
      />
    </div>
    <div>
      <!-- <record-view /> -->
    </div>
  </div>
</template>

<script>
import ResultModal from './sub-view/modal/ResultModal.vue';
import GameView from './sub-view/GameView.vue';
// import RecordView from './sub-view/RecordView.vue';

export default {
  components: {
    ResultModal,
    GameView,
    // RecordView,
  },
  data() {
    return {
      title: '',
      isEndGame: false,
      score: 0,
    };
  },
  methods: {
    setBlindGame() {
      this.isEndGame = true;
    },
    setModalTitle(e) {
      this.title = e;
    },
    onCloseModal() {
      this.isEndGame = false;
    },
    setScore(e) {
      this.score = e;
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
.blind {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.3);
  z-index: 20;
}
.modal {
  position: relative;
  background: white;
  width: 100px;
  transform: translate(-50%, -50%);
  top: 50%;
  left: 50%;
  padding: 10px;
  border: 1px solid rgba(168, 168, 168, 0.5) inset;
  border-radius: 15px;
  box-shadow: 0 0 5px 10px rgba(83, 83, 83, 0.2);
}
</style>
