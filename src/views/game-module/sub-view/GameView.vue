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
      if (e.path[0].id === this.question) {
        this.right += 1;
        this.setRight();
      } else {
        if (this.wrong > 0) this.wrong -= 1;
      }
    },
  },
};
</script>

<style lang="scss" scope>
:root {
  --color-block: #005c53;
  --color-block-hover: #00665c;
  --color-block-target: #042940;
  --color-block-target-hover: #053452;
  --size-cell: 100px;
  --size-result: 80px;
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
</style>
