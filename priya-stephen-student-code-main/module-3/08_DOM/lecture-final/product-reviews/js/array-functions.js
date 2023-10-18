
// cookFood('🐮', '🥔', '🐔', '🌽');
function cookFood(...foodItems){

  return foodItems.map( (eachFoodItem) => {
    if(eachFoodItem === '🐮') return '🍔';
    if(eachFoodItem === '🥔') return '🍟';
    if(eachFoodItem === '🐔') return '🍗';
    if(eachFoodItem === '🌽') return '🍿';
  });
}

// vegetarianFilter('🐮', '🥔', '🐔', '🌽');
function vegetarianFilter(...foodItems){

  return foodItems.filter( (eachFoodItem) => {
    if(eachFoodItem === '🥔') return true;
    if(eachFoodItem === '🌽') return true;
    return false;
  });
}

// foodReducer('🐮', '🥔', '🐔', '🌽');
function foodReducer(...foodItems){

  return foodItems.reduce( (total, eachFoodItem) => {
    if(eachFoodItem === '🐮') return '💩';
    if(eachFoodItem === '🥔') return '💩';
    if(eachFoodItem === '🐔') return '💩';
    if(eachFoodItem === '🌽') return '💩';
  }, '');
}