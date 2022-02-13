function onScanSuccess(html5QrcodeScanner) {
    return (decodedText, decodedResult) => {
        // Handle on success condition with the decoded text or result.
        console.log(`Scan result: ${decodedText}`, decodedResult);
        html5QrcodeScanner.clear();
    }
}

function onScanError(errorMessage) {
    // handle on error condition, with error message
}

function loadQRCodeScanner() {
    var html5QrcodeScanner = new Html5QrcodeScanner(
        "reader", { fps: 10, qrbox: 250 });
    
    html5QrcodeScanner.render(onScanSuccess(html5QrcodeScanner), onScanError);
}

function domReady(fn) {
    // If we're early to the party
    document.addEventListener("DOMContentLoaded", fn);
    // If late; I mean on time.
    if (document.readyState === "interactive" || document.readyState === "complete") {
        fn();
    }
}

domReady(loadQRCodeScanner);
