


import reducer from '../reducers';

import { createStore, applyMiddleware } from 'redux';
import { composeWithDevTools } from 'redux-devtools-extension';

import thunk from 'redux-thunk'

const composeEnhancers = composeWithDevTools({
    // Specify name here, actionsBlacklist, actionsCreators and other options if needed
});

const preloadedState = {
    items: [],
    reviews: {}
}

const store = createStore(reducer, preloadedState, composeEnhancers(
    // other store enhancers if any
    applyMiddleware(thunk)
));

export default store;