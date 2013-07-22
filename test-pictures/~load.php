<?php

$i = 40;
while ($i > 0) {
	$name = substr('00' . $i, -3) . ".jpg";
	$i--;
	if (file_exists($name)) {
		continue;
	}
	$file = file_get_contents('http://lorempixel.com/120/160/');
	echo "Saving $name\n";
	file_put_contents($name, $file);
}
