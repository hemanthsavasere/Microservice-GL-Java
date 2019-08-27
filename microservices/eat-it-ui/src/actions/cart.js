

import api from '../api'

export function buy(item, qty) {
    //..
    // return { type: 'BUY', item, qty }
    return function (dispatch) {
        api.buy('Nag', { item: { id: item.id, name: item.name, price: item.price }, qty })
            .then(response => response.data)
            .then(resp => {
                dispatch({ type: 'BUY', item })
            })
    }
}


export function loadCart() {
    //..
    return function (dispatch) {
        api.loadCart('Nag')
            .then(response => response.data)
            .then(resp => {
                dispatch({ type: 'LOAD_CART', cart: resp })
            })
    }
}


export function checkout() {
    //..
    // return { type: 'CHECKOUT' }
    return function (dispatch) {
        api.checkout('Nag')
            .then(response => response.data)
            .then(resp => {
                dispatch({ type: 'CHECKOUT', cart: {} })
            })
    }
}