<template>
  <div>
      <div class="container">
        <div class="add-btn">
            <button @click="addItem">Add Item</button>
        </div>
        <div class="item" v-for="(item, index) in items" :key="index">
            <div>
                Created: {{ item.created }}
            </div>
            <div class="select-box-container">
                <input type="checkbox" id="selectBox" v-model="item.selected"/>
                <label for="selectBox"
                    :class="{ 'selected-pane': item.selected }">{{ item.selected ? 'Selected' : 'Select' }}</label>
            </div>
        </div>
      </div>
  </div>
</template>

<script>
export default {
    data() {
        return {
            nextId: 2,
            items: [],
            nextItem: {
                created: new Date(),
                selected: false
            }
        }
    },
    methods: {
        getNextId() {
            return this.nextId++;
        },
        addItem() {

            /* works - code does not set selected property and lets v-model
                manage it completely */   
            this.items.push(this.nextItem);
            this.nextItem =  {
                created: new Date()
            }
            


            /* works - object created with selected property */
            /*
            this.items.push(this.nextItem);
            this.nextItem =  {
                created: new Date(),
                selected: false
            }*/

            /* DOES NOT WORK CORRECTLY !!! newly created nextItem does not set selected
                property and then this method sets the selected property to 
                false before pushing on to the item list
                */

               /*
            this.nextItem.selected = false
            this.items.push(this.nextItem);
            this.nextItem =  {
                created: new Date()
            }
            */
            




            
        }
    }

}
</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
}

.item {
    border: 2px solid black;
    padding: 10px;
    margin: 10px 0;
}

.select-box-container {
    text-align: left;
}

.selected-pane {
    background-color: green;
    color: white;
    padding: 5px;
}

</style>