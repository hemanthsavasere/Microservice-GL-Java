

import api from '../api';

export function login(email, password) {
    return function (dispatch) {
        api.doLogin(email, password)
            .then(response => response.data)
            .then(resp => {
                dispatch({ type: 'USER_LOGIN_SUCCESS', access_token: resp.id, userId: resp.userId })
            })
            .catch(err => {
                dispatch({ type: 'USER_LOGIN_FAILED', reason: err.message })
            })
    }
}