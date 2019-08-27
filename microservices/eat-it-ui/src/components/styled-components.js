
import styled from 'styled-components';


const Wrapper = styled.div`
    background-color: ${props => props.self === 'yes' ? '#DEF' : '#FDF'};
    padding: 10px;
    margin: 5px;
    border-radius: 10px;
`


export { Wrapper }
