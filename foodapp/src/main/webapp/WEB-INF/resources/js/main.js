function delFood(path) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống đang có lỗi! Vui lòng quay lại sau!");
        });
    }
}

function delStore(path) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống đang có lỗi! Vui lòng quay lại sau!");
        });
    }
}

function addStore(path) {
    fetch(path, {
        method: "post"
    }).then(res => {
        if (res.status === 201)
            location.reload();
        else
            alert("Hệ thống đang có lỗi! Vui lòng quay lại sau!");
    });
}

function delReq(path) {
    if (confirm("Bạn chắc chắn xóa không?") === true) {
        fetch(path, {
            method: "delete"
        }).then(res => {
            if (res.status === 204)
                location.reload();
            else
                alert("Hệ thống đang có lỗi! Vui lòng quay lại sau!");
        });
    }
}