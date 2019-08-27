



export function reviewsReducer(state = {}, action) {
    let { type } = action;
    switch (type) {
        case 'LOAD_REVIEWS_SUCCESS': {
            let { itemId, reviews } = action;
            // let existingReviews = state[itemId] || []
            // reviews = existingReviews.concat(reviews);
            return { ...state, [itemId]: reviews }
        }
        case 'ADD_NEW_REVIEW_SUCCESS': {
            let { itemId, review } = action;
            let existingReviews = state[itemId] || []
            let reviews = existingReviews.concat(review);
            return { ...state, [itemId]: reviews }
        }
        default:
            return state;
    }
}