<template>
  <div>
      <input type="button" value="Click Me" />
      <div>
          <div class="box-container">
        <h2>Select Days</h2>
      </div>
      <div class="box-container">
        <input id="sun" type="checkbox" value="sunday" v-model="selectedDays" />
        <label for="sun">Sunday</label>
      </div>
      <div class="box-container">
        <input id="mon" type="checkbox" value="monday" v-model="selectedDays" />
        <label for="mon">Monday</label>
      </div>
      <div class="box-container">
        <input
          id="tues"
          type="checkbox"
          value="tuesday"
          v-model="selectedDays"
        />
        <label for="tues">Tuesday</label>
      </div>
      <div class="box-container">
        <input
          id="wed"
          type="checkbox"
          value="wednesday"
          v-model="selectedDays"
        />
        <label for="wed">Wednesday</label>
      </div>
      <div class="box-container">
        <input
          id="thurs"
          type="checkbox"
          value="thursday"
          v-model="selectedDays"
        />
        <label for="thurs">Thursday</label>
      </div>
      <div class="box-container">
        <input id="fri" type="checkbox" value="friday" v-model="selectedDays" />
        <label for="fri">Friday</label>
      </div>
      <div class="box-container">
        <input
          id="sat"
          type="checkbox"
          value="saturday"
          v-model="selectedDays"
        />
        <label for="sat">Saturday</label>
      </div>
  </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            selectedDays: []
        }
    }

}
</script>

<style scoped>
input {
    font-size: 24px;
}

label {
    font-size: 24px;
}
</style>