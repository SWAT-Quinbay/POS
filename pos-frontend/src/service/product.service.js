import axios from "axios";
import { baseUrl } from "@/utils/urls"

export const addNewProduct = ({ productData , success ,  error}) => {
  axios
    .post(`${baseUrl}` , productData)
    .then((response) => {
      success && success(response);
    })
    .catch((e) => {
      error && error(e);
    });
}

export const updateProductDetail = ({ productId , productData , success ,  error}) => {
    axios
      .put(`${baseUrl}/${productId}`,productData)
      .then((response) => {
        success && success(response);
      })
      .catch((e) => {
        error && error(e);
      });
  }

  export const deleteProductData = ({ productId , success ,  error}) => {
    axios
      .delete(`${baseUrl}/${productId}`)
      .then((response) => {
        success && success(response);
      })
      .catch((e) => {
        error && error(e);
      });
  }

  export const getProductByName = ({ searchKey, successCallback, errorCallback }) => {
    axios
      .get(`${baseUrl}/search?name=${searchKey}&page=0&size=20`)
      .then((response) => {
        successCallback && successCallback(response);
      })
      .catch((e) => {
        errorCallback && errorCallback(e);
      });
  }

export const getInventory = ({ successCallback, errrorCallback }) => {
  axios
    .get(`${baseUrl}/all?page=0&size=100`)
    .then((response) => {
      successCallback && successCallback(response);
    })
    .catch((e) => {
      errrorCallback && errrorCallback(e);
    });
}


