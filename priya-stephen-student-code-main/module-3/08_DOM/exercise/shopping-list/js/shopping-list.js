// add pageTitle
const pageTitle = 'My Shopping List';

// add groceries
groceries = ['coconut', 'ginger', 'garlic', 'salt', 'tomatoes', 'onions', 'potatoes', 'black pepper', 'yogurt', 'lemon'];
/**
 * This function will get a reference to the title and set its text to the value
 * of the pageTitle variable that was set above.
 */
function setPageTitle() {
const titleElement = document.getElementById ('title');
titleElement.innerText = pageTitle;

}

/**
 * This function will loop over the array of groceries that was set above and add them to the DOM.
 */
function displayGroceries() {
 
  groceries.forEach(element => {

    let newListItem = document.createElement ('li');
    newListItem.innerText = element;
    let groceryList = document.getElementById ('groceries');
    groceryList.appendChild (newListItem);
  });

}

/**
 * This function will be called when the button is clicked. You will need to get a reference
 * to every list item and add the class completed to each one
 */
function markCompleted() {

groceryList = document.getElementById ('groceries');
groceryItems = groceryList.children;
groceryItemsArray = Array.from (groceryList.children);
groceryItemsArray.forEach ( (element) => {
  element.classList.add ('completed');
}); 

}

setPageTitle();

displayGroceries();

// Don't worry too much about what is going on here, we will cover this when we discuss events.
document.addEventListener('DOMContentLoaded', () => {
  // When the DOM Content has loaded attach a click listener to the button
  const button = document.querySelector('.btn');
  button.addEventListener('click', markCompleted);
});
