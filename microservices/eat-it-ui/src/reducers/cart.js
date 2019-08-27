
export function cartReducer(state = {}, action) {
    const { type } = action;
    switch (type) {
        case 'CHECKOUT':{
            return {}
        }
        case 'LOAD_CART': {
            //let cart = localStorage.getItem('user-cart')
            //cart = JSON.parse(cart) || {}
            //return cart;
            //return state;

            let { cart } = action;
            return cart;
        }
        case 'BUY': {
            let { item, qty } = action;
            qty = qty || 1
            let { id } = item;
            let cart = state;
            let cartLine;
            if (cart[id]) {
                cartLine = cart[id]
                cartLine = { ...cartLine, qty: cartLine.qty + qty }
            } else {
                cartLine = { item, qty: 1 }
            }
            cart = { ...cart, [id]: cartLine }
            //localStorage.setItem('user-cart', JSON.stringify(cart))
            return cart;

        }
        case 'CHECKOUT': {
            return {}
        }
        default:
            return state;
    }
}