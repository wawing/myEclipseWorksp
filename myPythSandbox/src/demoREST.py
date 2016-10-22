'''
Created on Oct 3, 2016
REST response
{
    "name":"India",
    "alpha2_code":"IN",
    "alpha3_code":"IND"
}

@author: ww
'''

import requests


resp = requests.get('http://services.groupkt.com/country/get/all')
print resp.status_code;

if resp.status_code != 200:
    # This means something went wrong.
    #raise errors.ApiError('GET /tasks/ {}'.format(resp.status_code))
    raise NameError("GET error detect")

for todo_item in resp.json():
    print('{} {}'.format(todo_item('name') ))
    
    #print resp.json();