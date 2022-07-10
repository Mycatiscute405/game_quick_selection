<template>
  <div>
    <div id="content">
      <div v-for="row in row" :key="row">
        <span
          :class="
            `${row}${column}` === `${question}` ? 'block-target' : 'block'
          "
          v-for="column in column"
          :key="column"
          :id="`${row}${column}`"
          @click="onClickBlock"
        >
          <p v-if="right < 0">
            {{ `${row}${column}` === `${question}` ? 'START' : '' }}
          </p>
        </span>
      </div>
    </div>
    <div id="content-bottom">
      <span class="result">{{ wrong }}</span>
      <span class="result">{{ right >= 0 ? right : 'ready' }}</span>
    </div>
    <div id="content-progress">
      <div class="progress-border">
        <div>
          <span></span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      row: 4,
      column: 4,
      question: '',

      right: -1,
      wrong: 3,
      lock: false,
      isEndGame: false,

      pg: 500, //entry progress value
      pgVal: '0px', //progress width (to css)
      pgColor: '#5B81F5',
    };
  },
  mounted() {
    this.setRight();
  },
  methods: {
    setRight() {
      const temp = this.question;
      while (temp === this.question) {
        const ranRow = Math.ceil(Math.random() * this.row);
        const ranColumn = Math.ceil(Math.random() * this.column);
        this.question = ranRow + '' + ranColumn;
      }
    },
    onClickBlock(e) {
      if (!this.lock && this.right === -1) {
        if (e.path[0].id === this.question) {
          this.right += 1;
          this.setRight();
          this.onProgrssbar();
        }
      } else if (!this.lock) {
        if (e.path[0].id === this.question) {
          this.right += 1;
          this.setRight();
        } else {
          if (this.wrong > 0) {
            this.wrong -= 1;
            if (this.wrong === 0) {
              this.onEndGame();
            }
          }
        }
      }
    },
    onProgrssbar() {
      let time = 0;
      const timer = setInterval(() => {
        time += Math.ceil(1 / this.pg);
        this.pgVal = time + '%';
        // rest 50%
        if (time === 50) {
          this.pgColor = '#F0F582';
        }
        // rest 25%
        if (time === 75) {
          this.pgColor = '#F5411C';
        }
        if (time >= 100 || this.wrong <= 0) {
          clearInterval(timer);
          setTimeout(() => {
            this.onEndGame(time);
          }, 100);
        }
      }, 100);
    },
    onEndGame(time) {
      let titleForModal = '';
      this.lock = true;
      if (time >= 100) {
        titleForModal = 'TIMEOVER!';
      }
      if (this.wrong === 0) {
        titleForModal = 'WRONGOVER!';
      }
      this.$emit('setBlindGame');
      this.$emit('setScore', this.right);
      this.$emit('setModalTitle', titleForModal);
    },
  },
};
</script>

<style lang="scss" scope>
$PG_SIZE: v-bind(pg);
$VAR_PG_SIZE: v-bind(pgVal);
$VAR_PG_COLOR: v-bind(pgColor);
:root {
  --color-block: #005c53;
  --color-block-hover: #00665c;
  --color-block-target: #042940;
  --color-block-target-hover: #053452;
  --size-cell: 100px;
  --size-result: 80px;
  --size-width-progress: 500px;
  --size-height-progress: 25px;
}

.block,
.block-target {
  cursor: pointer;
  display: inline-block;
  height: var(--size-cell);
  width: var(--size-cell);
  margin: 0 2px;
}
.block-target {
  background: var(--color-block-target);
  &:hover {
    transition: all 0.2s;
    background: var(--color-block-target-hover);
  }
  > p {
    pointer-events: none;
    position: relative;
    display: table-cell;
    line-height: var(--size-cell);
    width: var(--size-cell);
    font-weight: 500;
    font-size: 1.3rem;
    color: rgb(255, 242, 242);
  }
}

.block {
  background: var(--color-block);
  &:hover {
    transition: all 0.2s;
    background: var(--color-block-hover);
  }
}
#content-bottom {
  padding-top: 2rem;
}
.result {
  display: inline-block;
  width: var(--size-result);
  height: var(--size-result);
  margin: 0 10px;
  border-radius: 50%;
  color: white;
  line-height: var(--size-result);
  &:first-child {
    background: #8d0018;
  }
  &:nth-child(2) {
    background: #005b85;
  }
}

#content-progress {
  padding-top: 2rem;
}
.progress-border {
  position: relative;
  display: inline-block;
  width: var(--size-width-progress);
  height: 40px;
  background: #c5c5c5;
  border-radius: 20px;
  z-index: 10;
  > div {
    position: absolute;
    width: calc(var(--size-width-progress) - 15px);
    height: var(--size-height-progress);
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    border-radius: 20px;
    overflow: hidden;
    > span {
      position: absolute;
      display: inline-block;
      // width: $VAR_PG_SIZE;
      width: calc(100% - $VAR_PG_SIZE);
      height: var(--size-height-progress);
      left: 0;
      margin: auto 0;
      background: $VAR_PG_COLOR;
      transition: all 0.1s linear;
    }
  }
}
</style>
