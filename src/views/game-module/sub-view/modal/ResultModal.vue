<template>
  <div class="blind">
    <div class="modal">
      <div class="modal-title">{{ title }}</div>
      <div class="modal-content">
        <div>
          <p>RANK</p>
          <span>1</span>
        </div>
        <div>
          <p>SCORE</p>
          <span>{{ score }}</span>
        </div>
      </div>
      <div class="modal-bottom">
        <button>SUBMIT</button>
        <button @click="onCloseModal">CLOSE</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: String,
    score: Number,
  },
  methods: {
    onCloseModal() {
      this.$emit('onCloseModal');
    },
  },
};
</script>

<style lang="scss" scope>
.modal {
  width: 300px !important;
}
.modal-title {
  height: 50px;
  border-radius: 12px;
  line-height: 50px;
  background: rgb(72, 113, 160);
  color: white;
  font-size: 2rem;
}
.modal-content {
  position: relative;
  > div {
    display: inline-block;
    margin: 0 20px;
    > span {
      display: block;
      border-radius: 20px;
      width: 100px;
      height: 100px;
      line-height: 100px;
      font-size: 4em;
    }
    &:first-child > span {
      background: rgb(243, 255, 110);
    }
    &:nth-child(2) > span {
      background: rgb(255, 89, 89);
    }
  }
}
.modal-bottom {
  > button {
    width: 50%;
    line-height: 50px;
    height: 50px;
    background: rgb(72, 113, 160);
    color: white;
    font-size: 1.2em;
    border: 1px solid rgb(240, 240, 240);
    margin-top: 20px;
    cursor: pointer;
    &:first-child {
      border-radius: 12px 0 0 12px;
      &:hover {
        background: rgb(25, 98, 167);
      }
    }
    &:nth-child(2) {
      border-radius: 0 12px 12px 0;
      &:hover {
        background: rgb(25, 98, 167);
      }
    }
  }
}
</style>
