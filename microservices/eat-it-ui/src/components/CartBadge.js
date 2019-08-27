

import React from 'react';
import { connect } from 'react-redux'

const CartBadge = (props) => {
    const { value } = props;
    return (
        <div>
            <i className="fa fa-shopping-cart"></i>
            &nbsp;<span className="badge badge-danger">{value}</span>
            item(s) in cart
        </div>
    );
};

const mapStateToProps = state => {
    return {
        value: Object.keys(state.cart).length
    }
}

export default connect(mapStateToProps)(CartBadge);

