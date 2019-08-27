import React, { Component } from 'react';
import store from '../store'

import { Wrapper } from '../components/styled-components'

export function connect(mapStateToProps) {

    return function (InputComponent) {

        class Container extends Component {
            constructor(props) {
                super(props);
                let state = mapStateToProps(store.getState())
                this.state = state;
            }
            componentDidMount() {
                this.unsubscribe = store.subscribe(() => {
                    let state = mapStateToProps(store.getState())
                    this.setState({ ...state });
                })
            }
            componentWillUnmount() {
                this.unsubscribe();
            }
            render() {
                return (
                    <div>
                        <InputComponent {...this.state} />
                    </div>
                );
            }
        }

        Container.displayName = `<Connect(${InputComponent.name})>`

        return Container;

    }

}


export function withWrapper(InputComponent) {
    class Container extends Component {
        render() {
            return (
                <Wrapper self={this.props.self}>
                    <InputComponent {...this.props} />
                </Wrapper>
            );
        }
    }
    return Container;
}