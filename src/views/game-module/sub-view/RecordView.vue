<template>
  <div>
    <table>
      <thead>
        <tr>
          <th>RANK</th>
          <th>DATE</th>
          <th>NAME</th>
          <th>SCORE</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(i, idx) in 4" :key="idx">
          <td>{{ idx + 1 }}</td>
          <td>2022.07.08</td>
          <td>Park SuYoung</td>
          <td>53</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scope>
table {
  border: 1px solid rgba(128, 128, 128, 0.2);
  margin: 5rem auto !important;
  width: 30rem;
  border-collapse: collapse;
  > thead > tr {
    background: gray;
    > th {
      color: white;
      padding: 8px;
    }
  }
  > tbody > tr {
    &:nth-child(2n) {
      background: rgba(128, 128, 128, 0.1);
    }
    > td {
      padding: 10px;
    }
  }
}
</style>
