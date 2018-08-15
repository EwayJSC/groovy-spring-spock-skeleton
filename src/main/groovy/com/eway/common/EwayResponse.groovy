package com.eway.common

class EwayResponse<T> {

    EwayResponse(){}
    EwayResponse(T data){
        this.data = data
    }

    private T data

    T getData() {
        return data
    }

    void setData(T data) {
        this.data = data
    }

    @Override
    public String toString() {
        return "EwayResponse{" +
            "data=" + data +
            '}';
    }
}
