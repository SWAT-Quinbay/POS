import axios from "axios";
import baseUrl from "@/utils/urls"

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

export const getInventory = ({ success, error }) => {
  axios
    .get(`${baseUrl}`)
    .then((response) => {
      success && success(response);
    })
    .catch((e) => {
      error && error(e);
    });
}


