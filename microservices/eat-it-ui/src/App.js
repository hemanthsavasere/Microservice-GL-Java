

import React, { Component } from 'react';
import Navbar from './components/Navbar';
import ItemList from './components/ItemList'
import CartBadge from './components/CartBadge';
import CartView from './components/CartView';
import Home from './components/Home';
import NotFound from './components/NotFound';

import { connect } from 'react-redux'

import { BrowserRouter as Router, Route, Switch, Link } from 'react-router-dom';
import Login from './components/Login';
import { loadCart } from './actions/cart';

class App extends Component {

  renderItems() {
    return <ItemList />
  }
  renderCart() {
    return <CartView />
  }
  handleItemsRoute(props) {
    let { type } = props.match.params
    if (type === 'food')
      return this.renderItems()
    else return (<div>Nil</div>)
  }
  renderStatus() {
    let { reqStatus } = this.props;
    if (reqStatus.message)
      return (
        <div className="alert alert-warning">{reqStatus.message}</div>
      )
  }
  componentDidMount() {
    this.props.loadCart();
  }
  render() {
    return (
      <div>
        <Navbar value={"Eat-IT"} />
        <hr />
        <CartBadge />
        <hr />
        <Router>
          <div>
            <ul className="nav nav-pills">
              <li className="nav-item">
                <Link className="nav-link" to="/">home</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/items/food">food-items</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/cart">cart</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/orders">orders</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to="/login">login</Link>
              </li>
            </ul>
            <hr />
            <div className="container">
              {this.renderStatus()}
              <hr />
              <Switch>
                <Route path="/" exact={true} component={Home} />
                <Route path="/items/:type" render={props => this.handleItemsRoute(props)} />
                <Route path="/cart" render={props => this.renderCart()} />
                <Route path="/login" component={Login} />
                <Route component={NotFound} />
              </Switch>
            </div>
          </div>
        </Router>
      </div>
    );
  }
}

const mapStateToProps = state => {
  return {
    reqStatus: state.reqStatus
  }
}
const mapDispatchToProps = { loadCart }

export default connect(mapStateToProps, mapDispatchToProps)(App);

