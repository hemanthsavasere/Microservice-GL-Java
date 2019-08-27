


export function usersReducer(state = {}, action) {
    let { type } = action;
    switch (type) {
        case 'USER_LOGIN_SUCCESS':
            let { access_token, userId } = action;
            return { access_token, userId };
        case 'USER_LOGIN_FAILED':
            let { reason } = action;
            return { reason };
        default:
            return state;
    }
}