



export function reqStatusReducer(state = {}, action) {
    const { type } = action;
    switch (type) {
        case 'REQUEST_START':
            return { message: action.message };
        case 'REQUEST_END':
            return { message: action.message };
        case 'REQUEST_ERROR':
            return { message: action.message };
        default:
            return state;
    }
}