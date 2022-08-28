import axios from "axios";
import {  orderBaseUrl } from "@/utils/urls"

export const createNewOrder = ({ orderData , success ,  error}) => {
  axios
    .post(`${orderBaseUrl}/add`, orderData)
    .then((response) => {
      success && success(response);
    })
    .catch((e) => {
      error && error(e);
    });
}

export const deleteOrderHistory = ({ orderId , success ,  error}) => {
    axios
      .delete(`${orderBaseUrl}/${orderId}`)
      .then((response) => {
        success && success(response);
      })
      .catch((e) => {
        error && error(e);
      });
  }

export const getOrderHistory = ({ successCallback, errrorCallback }) => {
  axios
    .get(`${orderBaseUrl}/all?page=0&size=10`)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}


