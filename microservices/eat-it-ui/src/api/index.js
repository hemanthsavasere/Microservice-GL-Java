
import axios from 'axios';

const baseUrl = ''

const api = {
    loadItems() {
        return axios.get(`${'http://localhost:8182'}/items`)
    },
    loadReviews(itemId) {
        return axios.get(`${'http://localhost:8183'}/reviews/search/findByItemId?itemId=${itemId}`)
    },
    addNewReview(itemId, review) {
        review.itemId = itemId
        return axios.post(`${'http://localhost:8183'}/reviews`, review)
    },
    doLogin(email, password) {
        return axios.post(`${baseUrl}/Users/login`, { email, password })
    },
    buy(cartId,cartLine){
        return axios.post(`${'http://localhost:8184'}/cart/${cartId}`, cartLine)
    },
    loadCart(cartId){
        return axios.get(`${'http://localhost:8184'}/cart/${cartId}`)
    },
    checkout(cartId){
        return axios.get(`${'http://localhost:8185'}/cart/${cartId}`)
    }
}

export default api;

