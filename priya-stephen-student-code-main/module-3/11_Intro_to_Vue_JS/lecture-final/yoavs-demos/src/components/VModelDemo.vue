<template>
  <div>
      <form>
          <!-- <label for="name">Name: </label>
          <input id="name" type="text" v-model="name"
            placeholder="Enter a name" /> -->

            
          <!--  dynamic styling -->

          <label for="name"
            v-bind:class="{ redtext: name === '', italictext: name === ''}">Name: </label>  
          <input id="name" type="text" v-model.trim.lazy="name"
            placeholder="Enter a name"
            :class="{ 'border-red': name === '' }"/>
            
      </form>
  </div>
</template>

<script>
export default {
    data() {
        return {
            name: ''
        }
    }

}
</script>

<style scoped>
.redtext {
    color: red;
}

.italictext {
    font-style: italic;
}

.border-red {
    border: 2px solid red;
}
</style>