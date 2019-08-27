

import React from 'react';
import { connect } from 'react-redux'
import { buy,checkout } from '../actions/cart'

let total = 0.0;

function renderCartItems(cart, buy) {
    total = 0.0;
    let keys = Object.keys(cart);
    return keys.map((key, idx) => {
        let cartLine = cart[key];
        let { item, qty } = cartLine
        total += item.price * qty
        return (
            <tr key={idx}>
                <td>{item.name}</td>
                <td>&#8377;{item.price}</td>
                <td><span className="badge badge-dark"><i onClick={e => buy(item, qty + 1)} className="fa fa-plus"></i></span></td>
                <td>{qty}</td>
                <td><span className="badge badge-dark"><i onClick={e => buy(item, qty - 1)} className="fa fa-minus"></i></span></td>
                <td>&#8377;{item.price * qty}</td>
            </tr>
        )
    })
}

const CartView = (props) => {
    const { cart, buy,checkout } = props;
    if (Object.keys(cart).length === 0)
        return (
            <div>cart is empty</div>
        )
    else
        return (
            <div className="card">
                <div className="card-header">item(s) in cart</div>
                <div className="card-body">
                    <table className="table table-bordered table-sm">
                        <tbody>
                            {renderCartItems(cart, buy)}
                        </tbody>
                    </table>
                    <hr />
                    Total : &#8377;{total}
                    <hr />
                    <button onClick={checkout} className="btn btn-dark">checkout</button>
                </div>
            </div>
        );
};

const mapStateToProps = state => {
    return {
        cart: state.cart
    }
}
const mapDispatchToProps = { buy,checkout }
export default connect(mapStateToProps, mapDispatchToProps)(CartView);


