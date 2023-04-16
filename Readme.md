# Shareasy
Shareasy is a self-hosted web application that lets you share files easily. It supports resumable secure uploads
and downloads. Downloads can be limited by lifetime or download limit of blob. Uploaded files are sharable
using hard to guess URL or QR code which can be additionally secured with password.

# Running application
Todo
# Features
* Secure and reliable upload of files.
* Secure and reliable download of files.
* Cleanup of expired files.
* Share your files using either URL or QR code.
* Your files can only download people with thom you have shared link or QR code.
* Authorized and unauthorized users can upload and download files.

# Usage

### Uploading a blob
To upload blob, firstly we need to make POST request

Request:
```
```
Response:
```
```
Then we can upload chunks of size 4096KB of our blob, using PATCH request

Request:
```
```
Response:
```
```
After uploading of all chunks, the last request response will be

Response:
```
```
### Downloading a blob
Todo
# Todo
* Uploading of files
* Downloading of files
* Periodic cleanup of expired files
* Authorization and authentication
* Generating hard to guess URL and QR code
* Securing URL and QR codes with password