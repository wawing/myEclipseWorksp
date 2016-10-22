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
import json

resp = requests.get('http://services.groupkt.com/country/get/all')
print resp.status_code;

if resp.status_code != 200:
    # This means something went wrong.
    #raise errors.ApiError('GET /tasks/ {}'.format(resp.status_code))
    raise NameError("GET error detect")
'''
for todo_item in resp.json():
    #print('{} {}'.format(todo_item('name') ))
'''
print resp;  
print resp.json();
print resp.text;

# change the JSON string into a JSON object
jsonObject = json.loads(resp.text);
# print the keys and values
for key in jsonObject:
    value = jsonObject[key]
    print("The key and value are ({}) = ({})".format(key, value) )

for majorkey, subdict in jsonObject.iteritems():
    print "major Key is " + majorkey
    for subkey, value in subdict.iteritems():
            print "subkey is " + subkey, value

j = json.loads(resp.text);  #converts to dictionary
for x in j['RestResponse']['result']:
    print x['name']

pass
