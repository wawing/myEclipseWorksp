'''
Created on Apr 5, 2016

@author: ww
'''

''' 
Methods / Functions -- methods need to be defined before using it.
'''
def add(a,b):
    return a+b

def addFixedValue(a):
    y = 5
    return y +a
  
print add(1,2)
print addFixedValue(1) 

'''
Loops and if clauses
'''
i = 1
for i in range(1, 10):
    if i <= 5 :
        print  '%i Smaller or equal then 5.\n' % i,
    else:
        print '%i Larger then 5.\n' % i,


'''
Slicing and assertions
'''
s = "abcdefg"   #slicing starts at index 0
print "s=" + s,
print "\nlen of s: " + str(len(s)),
assert (s[0:4]=="abcd")     #slice out up to idx 4(0-3 only)
assert (s[4:]=="efg")       #after idx 4  to end of string
assert ("abcdefg"[4:0]=="") #after idx 4  to idx 0...does not make sense so return empty str
assert ("abcdefg"[0:2]=="ab") #up to idx 2
        