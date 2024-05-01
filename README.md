# Deterministic Long to UUID Converter

Main article: https://dharma-code.com/wordpress/index.php/2024/04/23/deterministic-uuid-converter-in-java/

Presents a class that converts numeric primary keys to UUIDs deterministically with an optional secret seed.

## The scenario

You have been tasked to migrate the primary key of an entity from Long to UUID.

## The requirements

* For any Long input, it should produce the same UUID output.
* An optional "seed" should be available, so that an environment-dependent secret can be used, preventing hackers from guessing the UUIDs that correspond to low-order Longs.
* We will be using the standard java.lang.Long and java.util.UUID.
* Our project will use Maven.