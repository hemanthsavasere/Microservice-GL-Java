import React, { Component } from 'react';

import { login } from '../actions/users'

import { connect } from 'react-redux'
import { Redirect } from 'react-router-dom'

class Login extends Component {
    state = {
        email: '',
        password: ''
    }
    handleChange(e) {
        let { id, value } = e.target
        this.setState({ [id]: value });
    }
    handleForm(e) {
        e.preventDefault();
        const { email, password } = this.state;
        let { login } = this.props;
        login(email, password)
    }
    render() {
        let { email, password } = this.state;
        let { user } = this.props;
        console.log(user)
        if (user.access_token) {
            return (
                <div>
                    <Redirect to="/items/food" />
                </div>
            )
        }
        else return (
            <div className="row">
                <div className="col-sm-6 col-md-6">
                    <div className="card">
                        <div className="card-header">Login Form</div>
                        <div className="card-body">
                            <form onSubmit={e => this.handleForm(e)}>
                                <div className="form-group">
                                    <label>Email</label>
                                    <input className="form-control" id="email" value={email} onChange={e => this.handleChange(e)} />
                                </div>
                                <div className="form-group">
                                    <label>Password</label>
                                    <input className="form-control" id="password" value={password} onChange={e => this.handleChange(e)} />
                                </div>
                                <button className="btn btn-sm btn-dark">submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

const mapStateToProps = state => {
    return {
        user: state.user
    }
}
const mapDispatchToProps = { login };
export default connect(mapStateToProps, mapDispatchToProps)(Login);