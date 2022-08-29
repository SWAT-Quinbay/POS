import axios from "axios";
import {  baseOrderUrl } from "@/utils/urls"

export const createNewOrder = ({ orderData , successCallback ,  errrorCallback}) => {
  axios
    .post(`${baseOrderUrl}/add`, orderData)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}

export const cancelOrder = ({ orderId , successCallback ,  errrorCallback}) => {
  axios
    .get(`${baseOrderUrl}/cancel/${orderId}`)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}

export const deleteOrderHistory = ({ orderId , success ,  error}) => {
    axios
      .delete(`${baseOrderUrl}/${orderId}`)
      .then((response) => {
        success && success(response);
      })
      .catch((e) => {
        error && error(e);
      });
  }

export const getOrderHistory = ({ successCallback, errrorCallback }) => {
  axios
    .get(`${baseOrderUrl}/all?page=0&size=10`)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}


