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
const pg = 500;
export default {
  data() {
    return {
      row: 4,
      column: 4,
      question: '',

      right: -1,
      wrong: 3,
      lock: false,
      pg: pg + 'px', //entry
      pgVal: pg + 'px', //var

      isEndGame: false,
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
      } else {
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
      const indexOfStr = this.pgVal.search(/[a-z|A-Z]/);
      let time = Number(this.pgVal.slice(0, indexOfStr));
      const timer = setInterval(() => {
        time -= 10;
        this.pgVal = time + 'px';
        console.log(time);
        if (time <= 0 || this.wrong <= 0) {
          clearInterval(timer);
          setTimeout(() => {
            this.onEndGame();
          }, 100);
        }
      }, 100);
    },
    onEndGame() {
      this.pgVal = '0px';
      this.lock = true;
      this.$emit('setBlindGame');
    },
  },
};
</script>

<style lang="scss" scope>
$PG_SIZE: v-bind(pg);
$VAR_PG_SIZE: v-bind(pgVal);
:root {
  --color-block: #005c53;
  --color-block-hover: #00665c;
  --color-block-target: #042940;
  --color-block-target-hover: #053452;
  --size-cell: 100px;
  --size-result: 80px;
  --size-height-progress: 25px;
}

.block,
.block-target {
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
  width: $PG_SIZE;
  height: 40px;
  background: #c5c5c5;
  border-radius: 20px;
  z-index: 10;
  > div {
    position: absolute;
    width: calc($PG_SIZE - 15px);
    height: var(--size-height-progress);
    transform: translate(-50%, -50%);
    top: 50%;
    left: 50%;
    border-radius: 20px;
    overflow: hidden;
    > span {
      position: absolute;
      display: inline-block;
      width: $VAR_PG_SIZE;
      height: var(--size-height-progress);
      left: 0;
      margin: auto 0;
      background: red;
      transition: all 0.1s linear;
    }
  }
}
</style>
