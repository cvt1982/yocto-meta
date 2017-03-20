SUMMARY = "File classification tool"
DESCRIPTION = "File attempts to classify files depending \
on their contents and prints a description if a match is found."
HOMEPAGE = "http://www.darwinsys.com/file/"
SECTION = "console/utils"

# two clause BSD
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;beginline=2;md5=6a7382872edb68d33e1a9398b6e03188"

SRC_URI[md5sum] = "b8a7127a63036cc1d087feea6b66646c"
SRC_URI[sha256sum] = "9479cc73498ad77f91d086f8ae8ada64b0a412de80c228666e5b99c1a96b26b5"

DEPENDS = "zlib file-replacement-native"
DEPENDS_class-native = "zlib-native"

SRC_URI = "https://github.com/file/file.git \
        "

SRCREV = "3c0874be4d3232d672b20f513451a39cfd7c585a"
#SRCREV = "ea2cd50d09bfc02ebbd066cad91f1883aba9a3ac"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OEMAKE_append_class-target = "-e FILE_COMPILE=${STAGING_BINDIR_NATIVE}/file-native/file"
EXTRA_OEMAKE_append_class-nativesdk = "-e FILE_COMPILE=${STAGING_BINDIR_NATIVE}/file-native/file"

FILES_${PN} += "${datadir}/misc/*.mgc"

do_install_append_class-native() {
	create_cmdline_wrapper ${D}/${bindir}/file \
		--magic-file ${datadir}/misc/magic.mgc
}

do_install_append_class-nativesdk() {
	create_cmdline_wrapper ${D}/${bindir}/file \
		--magic-file ${datadir}/misc/magic.mgc
}

BBCLASSEXTEND = "native nativesdk"
PROVIDES_append_class-native = " file-replacement-native"
# Don't use NATIVE_PACKAGE_PATH_SUFFIX as that hides libmagic from anyone who
# depends on file-replacement-native.
bindir_append_class-native = "/file-native"
