

import { itemsReducer } from './items';
import { reviewsReducer } from './reviews';
import { cartReducer } from './cart';
import { reqStatusReducer } from './req-status';
import { usersReducer } from './users';

import { combineReducers } from 'redux';


export default combineReducers({
    items: itemsReducer,
    reviews: reviewsReducer,
    cart: cartReducer,
    reqStatus: reqStatusReducer,
    user: usersReducer
})
