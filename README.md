# DigitalSignature
Authenticate users when receiving content from a party
# PROJECT OVERVIEW
A cryptographic hash function is a deterministic procedure that takes an arbitrary block of data and returns a fixed-size bit string, the (cryptographic) hash value, such that an accidental or intentional change to the data will change the hash value.
The data to be encoded is often called the "message", and the hash value is sometimes called the message digest or simply digests.

The ideal cryptographic hash function has four main or significant properties:

•	It is easy to compute the hash value for any given message,

•	It is infeasible to find a message that has a given hash,

•	It is infeasible to modify a message without changing its hash,

•	It is infeasible to find two different messages with the same hash.

Cryptographic hash functions have many information security applications, notably in digital signatures, message authentication codes (MACs), and other forms of authentication. They can also be used as ordinary hash functions, to index data in hash tables, for fingerprinting, to detect duplicate data or uniquely identify files, and as checksums to detect accidental data corruption. 

Indeed, in information security contexts, cryptographic hash values are sometimes called (digital) fingerprints, checksums, or just hash values, even though all these terms stand for functions with rather different properties and purposes.

The types of SHA1 are SHA-1, SHA-224, SHA-256, SHA-384, and SHA-512.Each Name has a number specified beside to it which says that it is a length of the generated Hash code.

The current stable (and fairly well tested) version of SHA-256/384/512 is version 1.0 RELEASE, but it does not include SHA-1 or SHA-224 functionality.
