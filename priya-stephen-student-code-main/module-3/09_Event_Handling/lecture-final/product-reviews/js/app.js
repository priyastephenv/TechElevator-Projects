const bookName = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
    "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  }
];

/**
 * Add product name to the page title.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = bookName;
}

/**
 * Add product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * Display all of the reviews in the reviews array.
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 * Add single review to the page.
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer;
  tmpl.querySelector('h3').innerText = review.title;
  tmpl.querySelector('p').innerText = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------

document.addEventListener('DOMContentLoaded', () => {

  // Set the product reviews page title.
  setPageTitle();
  // Set the product reviews page description.
  setPageDescription();
  // Display all of the product reviews on our page.
  displayReviews();

  // 1. Select <p class='description ...>
  const descriptionEl = document.querySelector('.description');

  // 2. Add mouse click listener to description element
  descriptionEl.addEventListener('click', (event) => {

    // How to get the element with the description???
    const clickedDescriptionEl = event.target;

    toggleDescriptionEdit(clickedDescriptionEl);
  });

  const descriptionEditEl = document.getElementById('inputDesc');

  descriptionEditEl.addEventListener('keyup', (event) => {
    // If the key pressed was 'enter', save
    if( event.key === 'Enter' ){
      exitDescriptionEdit(event.target, true);
    }
    else if( event.key === 'Escape' ){
      // If the key pressed was 'Escape', don't save
      exitDescriptionEdit(event.target, false);
    }
  });

  // When the mouse leaves the text box, remove edit
  descriptionEditEl.addEventListener('mouseleave', (event) => {
    exitDescriptionEdit(event.target, false);
  });

  /*
   * Add event listener to button!
   */
  // 1. Select the button
  const buttonEl = document.getElementById('btnToggleForm');
  
  // 2. Add click event listener
  buttonEl.addEventListener('click', showHideForm);

  // Add listener to the save button and prevent default GET / request
  const saveButtonEl = document.getElementById('btnSaveReview');
  saveButtonEl.addEventListener('click', (event) => {
    
    // Stop the GET / request
    event.preventDefault();

    saveReview();
  })
});

/**
 * Hide the description and show the text box.
 *
 * @param {Element} desc the element containing the description
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;
  textBox.value = desc.innerText;
  textBox.classList.remove('d-none');
  desc.classList.add('d-none');
  textBox.focus();
}

/**
 * Hide the text box and show the description.
 * If save is true, also set the description to the contents of the text box.
 *
 * @param {Element} textBox the input element containing the edited description
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    desc.innerText = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * Toggle visibility of the add review form.
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none');
    btn.innerText = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * Reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}

/**
 * Save the review that was added using the add review form.
 */
function saveReview() {
  console.log('saving review');

  // 1. Get the values from the form elements
  const name = document.getElementById('name').value;
  const title = document.getElementById('title').value;
  const rating = document.getElementById('rating').value;
  const reviewDescription = document.getElementById('review').value;

  // 2. Add form values to a review object
  // {
  //   reviewer: 'Malcolm Madwell',
  //   title: 'What a book!',
  //   review:
  //   "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
  //   rating: 3
  // }
  const newReview = {
    reviewer: name,
    title: title,
    review: reviewDescription,
    rating: rating
  };
  
  // 3. Push the new review object to the reviews array
  reviews.push(newReview);

  // 4. hide form / display reviews
  showHideForm();
  displayReview(newReview);
}


/* 
LECTURE DEMO

// Add listener to document (DOM) so my DOM manipulation occurrs
// after the DOMContentLoaded event
document.addEventListener('DOMContentLoaded', onDomLoad);

// Code to execute when the DOM is ready
function onDomLoad(){

// 1. Get element to listen for events
const buttonEl = document.getElementById('my-button');
const buttonEl2 = document.getElementById('my-button2');

// 2. Add the listener and the event to listen for
buttonEl.addEventListener('click', onButtonClick);
buttonEl2.addEventListener('click', onButtonClick);
buttonEl2.addEventListener('keyup', (event) => {
  console.log(`The key that was pressed/released was: ${event.key}`);

});

// 3. Define the callback to run when the event occurs
function onButtonClick(event){
  const elementThatWasClicked = event.target;

  elementThatWasClicked.innerText = 'OUCH!';

  console.log(elementThatWasClicked.innerText);
  //alert(elementThatWasClicked.innerText);
}
}
*/